import { useState } from "react";

const Editor = ({ onRun }) => {
  const [code, setCode] = useState(
    `using person.ID = 1

create user profile {
    Goal("Weight Loss")
    Diet("Vegetarian")
    Weight(70.5)
    Height(1.75)
    Allergies({"Nuts", "Gluten"})
    BusyTime({"09:00-17:00", "19:00-21:00"})
}

Exercises = {
    Squat { Weight = 60, Sets = 3, Reps = 5 }
    BenchPress { Weight = 45, Sets = 4, Reps = 8 }
    Crunches { Weight = -10, Sets = 3, Reps = 12 }
}`
  );

  return (
    <div className="editor-container">
      <div className="panel-header">
        <span>DSL Editor</span>
        <button
          className="button"
          onClick={() => {
            onRun(code);
          }}
        >
          Run
        </button>
      </div>
      <div className="panel-content">
        <textarea
          value={code}
          onChange={(e) => setCode(e.target.value)}
        />
      </div>
    </div>
  );
};

export default Editor;