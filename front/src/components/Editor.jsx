import { useState } from "react";

// пока консту зафигачим, потом функцию как положено
// эту херь из жсона возьмем
const Editor = ({ onRun }) => {
  const [code, setCode] = useState(
    `
  using dbo.food
  using person.ID = 1

  foreach person.food.parameter {
      include parameter into generation
  }

  while (parameters != done)
  {
      generate food. recipe schedule update
  }

  for (meals) {
      output meal.recipe.link
  }
  `
  );

  return (
    <div className="editor-container">
      <div className="panel-header">
        <span>DSL Editor</span>

        {/* TODO: че то нормальное сделать тут */}
        <button className="button" onClick={() => {
          onRun(code);
          alert("Пошло говно по трубам");
        }}>Run</button>

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
