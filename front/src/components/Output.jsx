const Output = () => {
    return (
      <div className="output-container">
        <div className="panel-header">
          <span>Output</span>
          <button className="button" onClick={() => alert("Лови маслину")}>Export</button>
        </div>
        <div className="panel-content">
          <div className="nutrition-card">
            <h2>Balanced Diet</h2>
            <p>Daily Target: 2000 calories</p>
            <div className="chart-container"></div>
            <h3>Macronutrient Distribution</h3>
            <div className="nutrition-progress">
              <div className="progress-item">
                <span>Protein</span>
                <strong>30%</strong>
                <div className="progress-bar">
                  <div className="progress-fill" style={{ width: "30%" }}></div>
                </div>
              </div>
              <div className="progress-item">
                <span>Carbs</span>
                <strong>40%</strong>
                <div className="progress-bar">
                  <div className="progress-fill" style={{ width: "40%" }}></div>
                </div>
              </div>
              <div className="progress-item">
                <span>Fat</span>
                <strong>30%</strong>
                <div className="progress-bar">
                  <div className="progress-fill" style={{ width: "30%" }}></div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  };
  
  export default Output;
  