import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

export default defineConfig({
  plugins: [react()],
  server: {
    host: '0.0.0.0', // Bind to all interfaces
    port: parseInt(process.env.PORT) || 5173, // Use Render's PORT env var
    strictPort: true, // Fail if port is already in use
    allowedHosts: [
      'localhost',
      '.onrender.com', // Allow all Render subdomains
      'dsl-fitness-food-lj2x.onrender.com' // Your specific domain
    ]
  },
  preview: {
    host: '0.0.0.0',
    port: parseInt(process.env.PORT) || 5173,
  }
})