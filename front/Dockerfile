# Use the official Node.js image as the base image
FROM node:18-alpine

# Set the working directory in the container
WORKDIR /usr/src/app

# Copy the package.json and package-lock.json files from the front directory
COPY front/package*.json ./

# Install dependencies
RUN npm install

# Copy the rest of the application code from the front directory
COPY front/ .

# Expose the port the app runs on
EXPOSE 5173

# Set environment variable for port binding (for Render)
ENV PORT=5173

# Start the app and bind to all interfaces
CMD ["npm", "run", "dev", "--", "--host", "0.0.0.0", "--port", "$PORT"]