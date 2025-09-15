import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {
  const [count, setCount] = useState(0)

  return (
      <Router>
        <Navbar />
        <Routes>
          <Route path="/" element={<Page color="#4281A4" />} />
          <Route path="/account" element={<Page color="#48A9A6" />} />
          <Route path="/plannew" element={<Page color="#E4DFDA" />} />
          <Route path="/mytrips" element={<Page color="#D4B483" />} />
          <Route path="/aboutus" element={<Page color="#C1666B" />} />
        </Routes>
      </Router>
    );
}

export default App
