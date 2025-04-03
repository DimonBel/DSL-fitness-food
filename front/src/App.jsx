import { useState } from "react";
import "./App.css";
import Header from "./components/Header";
import Editor from "./components/Editor";
import Output from "./components/Output";

function App() {
  const [outputData, setOutputData] = useState(null);
  const [isLoading, setIsLoading] = useState(false);
  const handleRun = async (code) => {
    setIsLoading(true);
    try {
      const response = await fetch('http://127.0.0.1:8080/data', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ code })
      });

      if (!response.ok) {
        throw new Error('Network response was not ok');
      }

      const data = await response.json();
      setOutputData(data);
    } catch (error) {
      console.error('Error:', error);
      alert('Error fetching data');
    } finally {
      setIsLoading(false);
    }
  };

  return (
    <div>
      <Header />
      <main className="main-layout">
        <Editor onRun={handleRun} />
        <Output outputData={outputData} isLoading={isLoading} />
      </main>
    </div>
  );
}

export default App;