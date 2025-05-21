import { useState } from "react";
import Editor from "react-simple-code-editor";
import { highlight, languages } from "prismjs";
import "prismjs/components/prism-clike";
import "prismjs/themes/prism.css";

const DSLEditor = ({ onRun }) => {
  const [code, setCode] = useState(`using person.ID = 1

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
}`);

  const highlightCode = (code) =>
    highlight(code, {
      ...languages.clike,
      // Statement types
      keyword: /\b(create|generate|select|output|using|while|for|foreach|include|in|where|Exercises)\b/g,
      
      // Types and declarations
      type: /\b(table|where)\b/g,
      
      // Operators
      operator: /([=<>+\-*/]|\.\.)/g,
      
      // Literals
      boolean: /\b(true|false)\b/g,
      number: /\b\d+(\.\d+)?\b/g,
      string: /"([^"]*)"|'([^']*)'/g,
      
      // Special constructs
      punctuation: /[{}()[\];:,.]/g,
      
      // Identifiers with path (for references)
      'reference-path': /(\w+(?:\.\w+)+)/g,
      
      // Block markers
      block: /(\{|\})/g

    }, 'dsl');

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
        <Editor
          value={code}
          onValueChange={setCode}
          highlight={highlightCode}
          padding={'1rem'}
          style={{
            fontFamily: '"Fira Code", monospace',
            fontSize: '1rem',
            fontWeight: '400',
            backgroundColor: 'transparent',
            minHeight: '200px',
            border: 'none',
            borderRadius: '4px',
            lineHeight: '1.5',
          }}
          
        />
      </div>
    </div>
  );
};

export default DSLEditor;