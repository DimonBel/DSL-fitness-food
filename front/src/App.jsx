import "./App.css";
import Header from "./components/Header";
import Editor from "./components/Editor";
import Output from "./components/Output";

function App() {
  const handleRun = (code) => {
    console.log("пошло говно по трубам", code);
  };

  return (
    <div>
      <Header />
      <main className="main-layout">
        <Editor onRun={handleRun} />
        <Output />
      </main>
    </div>
  );
}

export default App;
