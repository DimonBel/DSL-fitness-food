import React, { useRef } from 'react';
import html2canvas from 'html2canvas';
import jsPDF from 'jspdf';
import { BarChart, Bar, XAxis, YAxis, CartesianGrid, Tooltip, ResponsiveContainer, PieChart, Pie, Cell } from 'recharts';

const Output = ({ outputData, isLoading }) => {
  // export
  const panelRef = useRef();

  const exportToPDF = () => {
    const content = document.getElementById('div-for-export');
    html2canvas(content, {
      scrollY: -window.scrollY,
      windowHeight: content.scrollHeight,
    }).then(canvas => {
      const imgData = canvas.toDataURL('image/png');
  
      const pdf = new jsPDF('p', 'mm', 'a4');
      const pdfWidth = pdf.internal.pageSize.getWidth();
      const pdfHeight = pdf.internal.pageSize.getHeight();
  
      const imgProps = pdf.getImageProperties(imgData);
      const imgWidth = pdfWidth;
      const imgHeight = (imgProps.height * imgWidth) / imgProps.width;
  
      let position = 0;
  
      // Add pages if needed
      while (position < imgHeight) {
        const pageHeight = Math.min(pdfHeight, imgHeight - position);
        pdf.addImage(
          imgData,
          'PNG',
          0,
          -position,
          imgWidth,
          imgHeight
        );
        position += pdfHeight;
        if (position < imgHeight) pdf.addPage();
      }
  
      pdf.save('output.pdf');
    });
  };
  

  // Color schemes for charts
  const macroColors = {
    proteins: '#4F46E5',
    carbs: '#F59E0B',
    fats: '#EF4444'
  };

  const pieColors = ['#4F46E5', '#F59E0B', '#EF4444', '#10B981', '#8B5CF6'];

  // Function to calculate macro percentages for meals
  const calculateMacros = (meals) => {
    if (!meals || meals.length === 0) {
      return { isEmpty: true };
    }

    let totalProteins = 0;
    let totalCarbs = 0;
    let totalFats = 0;
    let totalCalories = 0;

    meals.forEach(meal => {
      if (meal.nutrition) {
        totalProteins += meal.nutrition.proteins || 0;
        totalCarbs += meal.nutrition.carbs || 0;
        totalFats += meal.nutrition.fats || 0;
        totalCalories += meal.nutrition.calories || 0;
      }
    });

    const total = totalProteins + totalCarbs + totalFats;
    if (total === 0) return { isEmpty: true };

    return {
      proteinPercent: Math.round((totalProteins / total) * 100),
      carbsPercent: Math.round((totalCarbs / total) * 100),
      fatPercent: Math.round((totalFats / total) * 100),
      totalCalories,
      totalProteins,
      totalCarbs,
      totalFats,
      isEmpty: false
    };
  };

  // Function to prepare chart data for meals
  const prepareMealChartData = (meals) => {
    if (!meals) return [];
    
    const mealTypes = {};
    meals.forEach(meal => {
      const type = meal.mealType || meal.diet || 'Other';
      if (!mealTypes[type]) {
        mealTypes[type] = { name: type, calories: 0, proteins: 0, carbs: 0, fats: 0 };
      }
      if (meal.nutrition) {
        mealTypes[type].calories += meal.nutrition.calories || 0;
        mealTypes[type].proteins += meal.nutrition.proteins || 0;
        mealTypes[type].carbs += meal.nutrition.carbs || 0;
        mealTypes[type].fats += meal.nutrition.fats || 0;
      }
    });

    return Object.values(mealTypes);
  };

  // Function to render meal plan from original structure
  const renderOriginalMealPlan = (mealPlan) => {
    if (!mealPlan || Object.keys(mealPlan).length === 0) return null;

    const macros = calculateMacros(
      Object.values(mealPlan).flat().filter(meal => meal.Name)
    );

    return (
      <div className="meal-plan-section">
        <h3>🍽️ Today's Meal Plan</h3>
        
        {!macros.isEmpty && (
          <div className="macros-chart">
            <h4>Macronutrient Distribution</h4>
            <div className="chart-container">
              <ResponsiveContainer width="100%" height={200}>
                <PieChart>
                  <Pie
                    data={[
                      { name: 'Proteins', value: macros.proteinPercent, color: macroColors.proteins },
                      { name: 'Carbs', value: macros.carbsPercent, color: macroColors.carbs },
                      { name: 'Fats', value: macros.fatPercent, color: macroColors.fats }
                    ]}
                    cx="50%"
                    cy="50%"
                    innerRadius={40}
                    outerRadius={80}
                    dataKey="value"
                  >
                    {[macroColors.proteins, macroColors.carbs, macroColors.fats].map((color, index) => (
                      <Cell key={`cell-${index}`} fill={color} />
                    ))}
                  </Pie>
                  <Tooltip formatter={(value) => `${value}%`} />
                </PieChart>
              </ResponsiveContainer>
            </div>
            <div className="macro-summary">
              <div className="macro-item">
                <span className="color-dot" style={{ backgroundColor: macroColors.proteins }}></span>
                Proteins: {macros.proteinPercent}% ({macros.totalProteins}g)
              </div>
              <div className="macro-item">
                <span className="color-dot" style={{ backgroundColor: macroColors.carbs }}></span>
                Carbs: {macros.carbsPercent}% ({macros.totalCarbs}g)
              </div>
              <div className="macro-item">
                <span className="color-dot" style={{ backgroundColor: macroColors.fats }}></span>
                Fats: {macros.fatPercent}% ({macros.totalFats}g)
              </div>
            </div>
          </div>
        )}

        <div className="meals-grid">
          {Object.entries(mealPlan).map(([mealType, meals]) => (
            meals?.length > 0 && (
              <div key={mealType} className="meal-type-section">
                <h4 className="meal-type-header">{mealType.charAt(0).toUpperCase() + mealType.slice(1)}</h4>
                <div className="meal-cards">
                  {meals.map((meal, index) => (
                    meal.Name && (
                      <div key={index} className="meal-card">
                        <div className="meal-header">
                          <h5>{meal.Name}</h5>
                          <span className="calories">{meal.Calories} kcal</span>
                        </div>
                        <div className="ingredients">
                          {meal.Ingredients?.join(', ')}
                        </div>
                        <div className="nutrition-info">
                          <span>P: {meal.Proteins}g</span>
                          <span>C: {meal.Carbs}g</span>
                          <span>F: {meal.Fats}g</span>
                        </div>
                      </div>
                    )
                  ))}
                </div>
              </div>
            )
          ))}
        </div>
      </div>
    );
  };

  // Function to render new meal structure
  const renderMealSearch = (data) => {
    if (!data.meals || data.meals.length === 0) return null;

    const macros = calculateMacros(data.meals);
    const chartData = prepareMealChartData(data.meals);

    return (
      <div className="meal-search-section">
        <h3>🔍 Meal Suggestions</h3>
        
        {data.parameters && (
          <div className="search-parameters">
            <h4>Search Parameters</h4>
            <div className="param-grid">
              {data.parameters.ingredients && (
                <div className="param-item">
                  <strong>Ingredients:</strong> {data.parameters.ingredients.join(', ')}
                </div>
              )}
              {data.parameters.diet && (
                <div className="param-item">
                  <strong>Diet:</strong> {data.parameters.diet}
                </div>
              )}
              {data.parameters.mealType && (
                <div className="param-item">
                  <strong>Meal Type:</strong> {data.parameters.mealType}
                </div>
              )}
            </div>
          </div>
        )}

        {!macros.isEmpty && chartData.length > 0 && (
          <div className="meal-analytics">
            <div className="analytics-grid">
              <div className="chart-section">
                <h4>Calories by Meal Type</h4>
                <ResponsiveContainer width="100%" height={250}>
                  <BarChart data={chartData}>
                    <CartesianGrid strokeDasharray="3 3" />
                    <XAxis dataKey="name" />
                    <YAxis />
                    <Tooltip />
                    <Bar dataKey="calories" fill="#4F46E5" />
                  </BarChart>
                </ResponsiveContainer>
              </div>
              
              <div className="macro-breakdown">
                <h4>Macro Distribution</h4>
                <div className="macro-bars">
                  <div className="macro-bar-item">
                    <label>Proteins ({macros.totalProteins}g)</label>
                    <div className="bar-container">
                      <div 
                        className="bar proteins" 
                        style={{ width: `${macros.proteinPercent}%` }}
                      ></div>
                      <span>{macros.proteinPercent}%</span>
                    </div>
                  </div>
                  <div className="macro-bar-item">
                    <label>Carbs ({macros.totalCarbs}g)</label>
                    <div className="bar-container">
                      <div 
                        className="bar carbs" 
                        style={{ width: `${macros.carbsPercent}%` }}
                      ></div>
                      <span>{macros.carbsPercent}%</span>
                    </div>
                  </div>
                  <div className="macro-bar-item">
                    <label>Fats ({macros.totalFats}g)</label>
                    <div className="bar-container">
                      <div 
                        className="bar fats" 
                        style={{ width: `${macros.fatPercent}%` }}
                      ></div>
                      <span>{macros.fatPercent}%</span>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        )}

        <div className="meals-table">
          <h4>Found {data.count || data.meals.length} Meals</h4>
          <div className="table-container">
            <table>
              <thead>
                <tr>
                  <th>Meal Name</th>
                  <th>Type</th>
                  <th>Calories</th>
                  <th>Protein</th>
                  <th>Carbs</th>
                  <th>Fats</th>
                  <th>Ingredients</th>
                </tr>
              </thead>
              <tbody>
                {data.meals.map((meal, index) => (
                  <tr key={index}>
                    <td className="meal-name">{meal.name}</td>
                    <td>{meal.mealType || meal.diet}</td>
                    <td>{meal.nutrition?.calories}</td>
                    <td>{meal.nutrition?.proteins}g</td>
                    <td>{meal.nutrition?.carbs}g</td>
                    <td>{meal.nutrition?.fats}g</td>
                    <td className="ingredients-cell">
                      {meal.ingredients?.slice(0, 3).join(', ')}
                      {meal.ingredients?.length > 3 && '...'}
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        </div>
      </div>
    );
  };

  // Function to render training schedule
  const renderTrainingSchedule = (trainingSchedule) => {
    if (!trainingSchedule) return null;

    const days = trainingSchedule.days || trainingSchedule;
    const hasWorkouts = Object.values(days).some(dayWorkouts => dayWorkouts?.length > 0);

    if (!hasWorkouts) return null;

    return (
      <div className="training-section">
        <h3>💪 Training Schedule</h3>
        <div className="training-grid">
          {Object.entries(days).map(([day, exercises]) => (
            <div key={day} className={`training-day ${exercises?.length > 0 ? 'has-workout' : 'rest-day'}`}>
              <h4 className="day-header">{day}</h4>
              {exercises?.length > 0 ? (
                <div className="exercises-list">
                  {exercises.map((exercise, index) => (
                    <div key={index} className="exercise-card">
                      <div className="exercise-header">
                        <h5>{exercise.name}</h5>
                        <span className="exercise-type">{exercise.type}</span>
                      </div>
                      <div className="exercise-details">
                        <div className="detail-item">
                          <span className="icon">⏱️</span>
                          <span>{exercise.duration} min</span>
                        </div>
                        <div className="detail-item">
                          <span className="icon">🔥</span>
                          <span>{exercise.intensity}</span>
                        </div>
                        {exercise.caloriesBurned && (
                          <div className="detail-item">
                            <span className="icon">⚡</span>
                            <span>{exercise.caloriesBurned} cal</span>
                          </div>
                        )}
                        {exercise.scheduledTime && (
                          <div className="detail-item">
                            <span className="icon">🕐</span>
                            <span>{exercise.scheduledTime}</span>
                          </div>
                        )}
                      </div>
                    </div>
                  ))}
                </div>
              ) : (
                <div className="rest-day-message">Rest Day</div>
              )}
            </div>
          ))}
        </div>
      </div>
    );
  };

  // Function to render weekly schedule
  const renderWeeklySchedule = (weeklySchedule) => {
    if (!weeklySchedule || !weeklySchedule.schedule) return null;

    return (
      <div className="weekly-schedule-section">
        <h3>📅 Weekly Workout Summary</h3>
        
        <div className="schedule-summary">
          <div className="summary-item">
            <span className="label">Total Workouts</span>
            <span className="value">{weeklySchedule.totalWorkouts}</span>
          </div>
          <div className="summary-item">
            <span className="label">Estimated Weekly Calories</span>
            <span className="value">{weeklySchedule.estimatedWeeklyCalories} kcal</span>
          </div>
          <div className="summary-item">
            <span className="label">Workout Days</span>
            <span className="value">{weeklySchedule.workoutDays?.join(', ')}</span>
          </div>
        </div>

        {renderTrainingSchedule(weeklySchedule.schedule)}
      </div>
    );
  };

  // Function to render recommendations
  const renderRecommendations = (recommendations) => {
    if (!recommendations || recommendations.length === 0) return null;

    return (
      <div className="recommendations-section">
        <h3>💡 Recommendations</h3>
        <ul className="recommendations-list">
          {recommendations.map((rec, index) => (
            <li key={index} className="recommendation-item">
              {rec}
            </li>
          ))}
        </ul>
      </div>
    );
  };

  // Function to render optimal times
  const renderOptimalTimes = (optimalTimes) => {
    if (!optimalTimes) return null;

    return (
      <div className="optimal-times-section">
        <h3>⏰ Optimal Times</h3>
        <div className="times-grid">
          {Object.entries(optimalTimes).map(([key, value]) => (
            key !== 'notes' && (
              <div key={key} className="time-item">
                <div className="time-label">{key.charAt(0).toUpperCase() + key.slice(1)}</div>
                <div className="time-value">{value}</div>
              </div>
            )
          ))}
        </div>
        {optimalTimes.notes && (
          <div className="notes">
            <strong>Note:</strong> {optimalTimes.notes}
          </div>
        )}
      </div>
    );
  };

  // Function to render user profile
  const renderUserProfile = (userData) => {
    if (!userData) return null;

    const bmi = userData.bmi || (userData.weight / Math.pow(userData.height, 2));

    return (
      <div className="profile-section">
        <h3>👤 Profile Summary</h3>
        <div className="profile-grid">
          <div className="profile-item">
            <span className="label">Name</span>
            <span className="value">{userData.name}</span>
          </div>
          {userData.caloriesPerDay && (
            <div className="profile-item">
              <span className="label">Daily Target</span>
              <span className="value highlight">{Math.round(userData.caloriesPerDay)} kcal</span>
            </div>
          )}
          <div className="profile-item">
            <span className="label">BMI</span>
            <span className="value">{bmi?.toFixed(1)}</span>
          </div>
          <div className="profile-item">
            <span className="label">Goal</span>
            <span className="value">{userData.goal}</span>
          </div>
          <div className="profile-item">
            <span className="label">Exercise Experience</span>
            <span className="value">{userData.exerciseExperience} years</span>
          </div>
          {userData.allergies?.length > 0 && (
            <div className="profile-item full-width">
              <span className="label">Allergies</span>
              <span className="value warning">{userData.allergies.join(', ')}</span>
            </div>
          )}
        </div>
      </div>
    );
  };

  if (!outputData) {
    return (
      <div className="output-container">
        <div className="panel-header">
          <span>Output</span>
          <button className="export-button">Export</button>
        </div>
        <div className="panel-content empty-state">
          <div className="empty-message">
            <p>Run the DSL code to generate your personalized plan.</p>
          </div>
        </div>
      </div>
    );
  }

  return (
    <div className="output-container">
      <div className="panel-header">
        <span>Output</span>
        <button className="export-button" onClick={exportToPDF}>Export</button>
      </div>

      <div className="panel-content" ref={panelRef} id="div-for-export">
        {isLoading ? (
          <div className="loading-spinner"></div>
        ) : (
          <div className="dashboard">
            {/* Render user profile if available */}
            {(outputData.user || outputData.name) && renderUserProfile(outputData.user || outputData)}
            
            {/* Render optimal times if available */}
            {outputData.optimalTimes && renderOptimalTimes(outputData.optimalTimes)}
            
            {/* Render weekly schedule if available */}
            {outputData.weeklySchedule && renderWeeklySchedule(outputData.weeklySchedule)}
            
            {/* Render meal data - handle both old and new structures */}
            {outputData.meals && renderMealSearch(outputData)}
            {outputData.mealPlan && renderOriginalMealPlan(outputData.mealPlan)}
            
            {/* Render training schedule */}
            {outputData.trainingSchedule && !outputData.weeklySchedule && renderTrainingSchedule(outputData.trainingSchedule)}
            
            {/* Render recommendations */}
            {outputData.recommendations && renderRecommendations(outputData.recommendations)}
            
            {/* Status indicator */}
            {outputData.status && (
              <div className={`status-indicator ${outputData.status}`}>
                Status: {outputData.status}
              </div>
            )}
          </div>
        )}
      </div>

      <style jsx>{`
        .output-container {
          height: 100%;
          display: flex;
          flex-direction: column;
        }

        .panel-header {
          display: flex;
          justify-content: space-between;
          align-items: center;
          border-bottom: 1px solid #e5e7eb;
          font-weight: 600;
          color: #374151;
        }

        .export-button {
          background: #4f46e5;
          color: white;
          border: none;
          padding: 8px 16px;
          border-radius: 6px;
          cursor: pointer;
          font-size: 14px;
          transition: background 0.2s;
        }

        .export-button:hover {
          background: #4338ca;
        }

        .panel-content {
          flex: 1;
          overflow-y: auto;
        }

        .empty-state {
          display: flex;
          align-items: center;
          justify-content: center;
          height: 100%;
          color: #6b7280;
          text-align: center;
        }

        .loading-spinner {
          display: flex;
          justify-content: center;
          align-items: center;
          height: 200px;
        }

        .loading-spinner::after {
          content: '';
          width: 40px;
          height: 40px;
          border: 4px solid #f3f4f6;
          border-top: 4px solid #4f46e5;
          border-radius: 50%;
          animation: spin 1s linear infinite;
        }

        @keyframes spin {
          0% { transform: rotate(0deg); }
          100% { transform: rotate(360deg); }
        }

        .dashboard {
          display: flex;
          flex-direction: column;
          gap: 24px;
        }

        .profile-section,
        .meal-plan-section,
        .meal-search-section,
        .training-section,
        .optimal-times-section,
        .weekly-schedule-section,
        .recommendations-section {
          background: #f9fafb;
          border-radius: 12px;
          padding: 24px;
        }

        .profile-section h3,
        .meal-plan-section h3,
        .meal-search-section h3,
        .training-section h3,
        .optimal-times-section h3,
        .weekly-schedule-section h3,
        .recommendations-section h3 {
          margin: 0 0 20px 0;
          color: #111827;
          font-size: 18px;
          font-weight: 600;
        }

        .profile-grid {
          display: grid;
          grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
          gap: 16px;
        }

        .profile-item {
          display: flex;
          justify-content: space-between;
          align-items: center;
          padding: 12px 16px;
          background: white;
          border-radius: 8px;
          border: 1px solid #e5e7eb;
        }

        .profile-item.full-width {
          grid-column: 1 / -1;
        }

        .label {
          color: #6b7280;
          font-size: 14px;
          font-weight: 500;
        }

        .value {
          color: #111827;
          font-weight: 600;
        }

        .value.highlight {
          color: #4f46e5;
          font-size: 16px;
        }

        .value.warning {
          color: #ef4444;
        }

        .chart-container {
          height: 200px;
          margin: 16px 0;
        }

        .macro-summary {
          display: flex;
          justify-content: space-around;
          margin-top: 16px;
        }

        .macro-item {
          display: flex;
          align-items: center;
          gap: 8px;
          font-size: 14px;
        }

        .color-dot {
          width: 12px;
          height: 12px;
          border-radius: 50%;
        }

        .meals-grid {
          display: flex;
          flex-direction: column;
          gap: 24px;
        }

        .meal-type-section h4 {
          color: #4f46e5;
          margin-bottom: 16px;
          font-size: 16px;
          font-weight: 600;
        }

        .meal-cards {
          display: grid;
          grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
          gap: 16px;
        }

        .meal-card {
          background: white;
          border-radius: 8px;
          padding: 16px;
          border: 1px solid #e5e7eb;
          transition: box-shadow 0.2s;
        }

        .meal-card:hover {
          box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .meal-header {
          display: flex;
          justify-content: space-between;
          align-items: center;
          margin-bottom: 8px;
        }

        .meal-header h5 {
          margin: 0;
          color: #111827;
          font-size: 14px;
          font-weight: 600;
        }

        .calories {
          background: #ddd6fe;
          color: #5b21b6;
          padding: 4px 8px;
          border-radius: 4px;
          font-size: 12px;
          font-weight: 600;
        }

        .ingredients {
          color: #6b7280;
          font-size: 13px;
          margin-bottom: 8px;
        }

        .nutrition-info {
          display: flex;
          gap: 12px;
          font-size: 12px;
          color: #374151;
          font-weight: 500;
        }

        .table-container {
          overflow-x: auto;
          margin-top: 16px;
        }

        table {
          width: 100%;
          border-collapse: collapse;
          background: white;
          border-radius: 8px;
          overflow: hidden;
          box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
        }

        th,
        td {
          padding: 12px;
          text-align: left;
          border-bottom: 1px solid #e5e7eb;
        }

        th {
          background: #f3f4f6;
          font-weight: 600;
          color: #374151;
          font-size: 14px;
        }

        td {
          font-size: 13px;
          color: #6b7280;
        }

        .meal-name {
          color: #111827;
          font-weight: 600;
        }

        .ingredients-cell {
          max-width: 200px;
          overflow: hidden;
          text-overflow: ellipsis;
          white-space: nowrap;
        }

        .training-grid {
          display: grid;
          grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
          gap: 16px;
        }

        .training-day {
          background: white;
          border-radius: 8px;
          padding: 16px;
          border: 2px solid #e5e7eb;
        }

        .training-day.has-workout {
          border-color: #4f46e5;
        }

        .training-day.rest-day {
          border-color: #d1d5db;
          opacity: 0.7;
        }

        .day-header {
          margin: 0 0 12px 0;
          color: #111827;
          font-size: 16px;
          font-weight: 600;
        }

        .exercises-list {
          display: flex;
          flex-direction: column;
          gap: 12px;
        }

        .exercise-card {
          background: #f9fafb;
          border-radius: 6px;
          padding: 12px;
        }

        .exercise-header {
          display: flex;
          justify-content: space-between;
          align-items: center;
          margin-bottom: 8px;
        }

        .exercise-header h5 {
          margin: 0;
          color: #111827;
          font-size: 14px;
          font-weight: 600;
        }

        .exercise-type {
          background: #dbeafe;
          color: #1e40af;
          padding: 4px 8px;
          border-radius: 4px;
          font-size: 11px;
          font-weight: 600;
        }

        .exercise-details {
          display: flex;
          flex-wrap: wrap;
          gap: 8px;
        }

        .detail-item {
          display: flex;
          align-items: center;
          gap: 4px;
          font-size: 12px;
          color: #6b7280;
        }

        .icon {
          font-size: 14px;
        }

        .rest-day-message {
          text-align: center;
          color: #9ca3af;
          font-style: italic;
          padding: 20px;
        }

        .times-grid {
          display: grid;
          grid-template-columns: repeat(auto-fit, minmax(150px, 1fr));
          gap: 16px;
          margin-bottom: 16px;
        }

        .time-item {
          background: white;
          border-radius: 8px;
          padding: 16px;
          text-align: center;
          border: 1px solid #e5e7eb;
        }

        .time-label {
          color: #6b7280;
          font-size: 14px;
          margin-bottom: 4px;
        }

        .time-value {
          color: #111827;
          font-size: 18px;
          font-weight: 600;
        }

        .notes {
          background: #fef3c7;
          border: 1px solid #fbbf24;
          border-radius: 6px;
          padding: 12px;
          color: #92400e;
          font-size: 14px;
        }

        .analytics-grid {
          display: grid;
          grid-template-columns: 2fr 1fr;
          gap: 24px;
          margin-bottom: 24px;
        }

        .chart-section {
          background: white;
          border-radius: 8px;
          padding: 16px;
        }

        .macro-breakdown {
          background: white;
          border-radius: 8px;
          padding: 16px;
        }

        .macro-bars {
          display: flex;
          flex-direction: column;
          gap: 12px;
        }

        .macro-bar-item {
          display: flex;
          flex-direction: column;
          gap: 4px;
        }

        .macro-bar-item label {
          font-size: 14px;
          color: #374151;
          font-weight: 500;
        }

        .bar-container {
          display: flex;
          align-items: center;
          gap: 8px;
        }

        .bar {
          height: 20px;
          border-radius: 10px;
          transition: width 0.3s ease;
        }

        .bar.proteins {
          background: #4f46e5;
        }

        .bar.carbs {
          background: #f59e0b;
        }

        .bar.fats {
          background: #ef4444;
        }

        .bar-container span {
          font-size: 12px;
          color: #6b7280;
          min-width: 35px;
        }

        .status-indicator {
          text-align: center;
          padding: 12px;
          border-radius: 6px;
          font-weight: 600;
        }

        .status-indicator.success {
          background: #d1fae5;
          color: #065f46;
        }

        .search-parameters {
          background: white;
          border-radius: 8px;
          padding: 16px;
          margin-bottom: 24px;
        }

        .search-parameters h4 {
          margin: 0 0 12px 0;
          color: #111827;
          font-size: 16px;
          font-weight: 600;
        }

        .param-grid {
          display: grid;
          grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
          gap: 12px;
        }

        .param-item {
          padding: 8px 12px;
          background: #f3f4f6;
          border-radius: 6px;
          font-size: 14px;
        }

        .param-item strong {
          color: #4f46e5;
        }

        /* Weekly schedule styles */
        .schedule-summary {
          display: grid;
          grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
          gap: 16px;
          margin-bottom: 24px;
        }

        .summary-item {
          background: white;
          border-radius: 8px;
          padding: 16px;
          border: 1px solid #e5e7eb;
        }

        .summary-item .label {
          display: block;
          color: #6b7280;
          font-size: 14px;
          margin-bottom: 4px;
        }

        .summary-item .value {
          color: #111827;
          font-size: 18px;
          font-weight: 600;
        }

        /* Recommendations styles */
        .recommendations-list {
          padding-left: 20px;
          margin: 0;
        }

        .recommendation-item {
          margin-bottom: 8px;
          color: #374151;
          line-height: 1.5;
        }

        .recommendation-item:last-child {
          margin-bottom: 0;
        }

        @media (max-width: 768px) {
          .analytics-grid {
            grid-template-columns: 1fr;
          }
          
          .profile-grid {
            grid-template-columns: 1fr;
          }
          
          .training-grid {
            grid-template-columns: 1fr;
          }
          
          .meal-cards {
            grid-template-columns: 1fr;
          }
          
          .times-grid {
            grid-template-columns: repeat(2, 1fr);
          }

          .schedule-summary {
            grid-template-columns: 1fr;
          }
        }
      `}</style>
    </div>
  );
};

export default Output;