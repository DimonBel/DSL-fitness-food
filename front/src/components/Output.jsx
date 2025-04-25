const Output = ({ outputData, isLoading }) => {
  // Функция для расчета процентов макронутриентов
  const calculateMacros = (mealPlan) => {
    // Если данных нет, возвращаем нулевые значения
    if (!mealPlan || Object.keys(mealPlan).length === 0) {
      return {
        proteinPercent: 0,
        carbsPercent: 0,
        fatPercent: 0,
        isEmpty: true
      };
    }

    let totalProteins = 0;
    let totalCarbs = 0;
    let totalFats = 0;

    // Расчет суммарных значений
    Object.values(mealPlan).forEach(meals => {
      meals.forEach(meal => {
        totalProteins += meal.Proteins || 0;
        totalCarbs += meal.Carbs || 0;
        totalFats += meal.Fats || 0;
      });
    });

    const total = totalProteins + totalCarbs + totalFats;

    // Если все нули, возвращаем пустые значения
    if (total === 0) {
      return {
        proteinPercent: 0,
        carbsPercent: 0,
        fatPercent: 0,
        isEmpty: true
      };
    }

    return {
      proteinPercent: Math.round((totalProteins / total) * 100),
      carbsPercent: Math.round((totalCarbs / total) * 100),
      fatPercent: Math.round((totalFats / total) * 100),
      isEmpty: false
    };
  };

  const macros = calculateMacros(outputData?.MealPlan);

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
        <button className="export-button">Export</button>
      </div>

      <div className="panel-content">
        {isLoading ? (
          <div className="loading-spinner"></div>
        ) : (
          <div className="dashboard">
            {/* Profile Summary */}
            <div className="profile-card">
              <div className="profile-header">
                <h3><i className="icon-user"></i> Your Profile Summary</h3>
              </div>
              <div className="profile-grid">
                <div className="profile-item">
                  <span className="label">Daily Target</span>
                  <span className="value highlight">{Math.round(outputData.caloriesPerDay)} kcal</span>
                </div>
                <div className="profile-item">
                  <span className="label">BMI</span>
                  <span className="value">{outputData.bmi?.toFixed(1)}</span>
                </div>
                <div className="profile-item">
                  <span className="label">Goal</span>
                  <span className="value">{outputData.goal}</span>
                </div>
                <div className="profile-item">
                  <span className="label">Diet</span>
                  <span className="value">{outputData.diet}</span>
                </div>
                {outputData.allergies?.length > 0 && (
                  <div className="profile-item full-width">
                    <span className="label">Allergies</span>
                    <span className="value warning">{outputData.allergies.join(', ')}</span>
                  </div>
                )}
              </div>
            </div>

            {/* Macronutrients */}
            <div className="macronutrients-section">
              <h3>Macronutrient Distribution</h3>

              {macros.isEmpty ? (
                <div className="empty-macros">
                  <p>No meal data available to calculate macronutrients</p>
                  <div className="macros-placeholder">
                    <div className="macro-item">
                      <div className="macro-bar" style={{ width: '0%' }}></div>
                      <span>Protein</span>
                      <span>0%</span>
                    </div>
                    <div className="macro-item">
                      <div className="macro-bar" style={{ width: '0%' }}></div>
                      <span>Carbs</span>
                      <span>0%</span>
                    </div>
                    <div className="macro-item">
                      <div className="macro-bar" style={{ width: '0%' }}></div>
                      <span>Fat</span>
                      <span>0%</span>
                    </div>
                  </div>
                </div>
              ) : (
                <div className="macros-visualization">
                  <div className="macro-item">
                    <div
                      className="macro-bar protein"
                      style={{ width: `${macros.proteinPercent}%` }}
                    ></div>
                    <span>Protein</span>
                    <span>{macros.proteinPercent}%</span>
                  </div>
                  <div className="macro-item">
                    <div
                      className="macro-bar carbs"
                      style={{ width: `${macros.carbsPercent}%` }}
                    ></div>
                    <span>Carbs</span>
                    <span>{macros.carbsPercent}%</span>
                  </div>
                  <div className="macro-item">
                    <div
                      className="macro-bar fat"
                      style={{ width: `${macros.fatPercent}%` }}
                    ></div>
                    <span>Fat</span>
                    <span>{macros.fatPercent}%</span>
                  </div>
                </div>
              )}
            </div>

            {/* Meal Plan */}
            <div className="meal-plan-card">
              <h3><i className="icon-cutlery"></i> Today's Meal Plan</h3>
              <div className="meals-container">
                {outputData.MealPlan && Object.entries(outputData.MealPlan).map(([mealType, meals]) => (
                  meals?.length > 0 && (
                    <div key={mealType} className="meal-section">
                      <h4 className="meal-type">{mealType}</h4>
                      <div className="meal-items">
                        {meals.map((meal, index) => (
                          <div key={index} className="meal-item">
                            <div className="meal-header">
                              <h5>{meal.Name}</h5>
                              <span className="calories">{meal.Calories} kcal</span>
                            </div>
                            <div className="meal-macros">
                              <div className="macro">
                                <span className="macro-label">Protein</span>
                                <span className="macro-value">{meal.Proteins}g</span>
                              </div>
                              <div className="macro">
                                <span className="macro-label">Carbs</span>
                                <span className="macro-value">{meal.Carbs}g</span>
                              </div>
                              <div className="macro">
                                <span className="macro-label">Fat</span>
                                <span className="macro-value">{meal.Fats}g</span>
                              </div>
                            </div>
                          </div>
                        ))}
                      </div>
                    </div>
                  )
                ))}
              </div>
            </div>

            {/* Training Schedule */}
            <div className="training-card">
              <h3><i className="icon-exercise"></i> Training Schedule</h3>
              <div className="training-days">
                {outputData.TrainingSchedule && Object.entries(outputData.TrainingSchedule).map(([day, exercises]) => (
                  exercises?.length > 0 && (
                    <div key={day} className="training-day">
                      <h4 className="day-name">{day}</h4>
                      <div className="exercises">
                        {exercises.map((exercise, index) => (
                          <div key={index} className="exercise">
                            <div className="exercise-header">
                              <h5>{exercise.Name}</h5>
                              <span className="exercise-type">{exercise.Type}</span>
                            </div>
                            <div className="exercise-details">
                              <span><i className="icon-clock"></i> {exercise.Duration} min</span>
                              <span><i className="icon-intensity"></i> {exercise.Intensity}</span>
                            </div>
                          </div>
                        ))}
                      </div>
                    </div>
                  )
                ))}
              </div>
            </div>
          </div>
        )}
      </div>
    </div>
  );
};

export default Output;