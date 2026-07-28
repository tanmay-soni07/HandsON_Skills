import React, { useState } from 'react';
import './App.css';

// Component 1: Book Details
const BookDetails = () => (
  <div style={{ padding: '10px', border: '1px solid blue', margin: '10px' }}>
    <h3>Book Details</h3>
    <p>Title: "React for Beginners"</p>
    <p>Author: John Doe</p>
  </div>
);

// Component 2: Blog Details
const BlogDetails = () => (
  <div style={{ padding: '10px', border: '1px solid green', margin: '10px' }}>
    <h3>Blog Details</h3>
    <p>Topic: "Why learn React in 2026?"</p>
    <p>Date: July 24, 2026</p>
  </div>
);

// Component 3: Course Details
const CourseDetails = () => (
  <div style={{ padding: '10px', border: '1px solid red', margin: '10px' }}>
    <h3>Course Details</h3>
    <p>Course Name: "Advanced Frontend Development"</p>
    <p>Duration: 4 Weeks</p>
  </div>
);

function App() {
  const [showBook, setShowBook] = useState(false);
  const [showBlog, setShowBlog] = useState(false);
  const [showCourse, setShowCourse] = useState(false);
  const [activeTab, setActiveTab] = useState('');

  // 1. Using If/Else conditional rendering (for Book Details)
  let bookContent;
  if (showBook) {
    bookContent = <BookDetails />;
  } else {
    bookContent = <p>Click to view Book Details (rendered via If/Else)</p>;
  }

  // 4. Using Switch Statement conditional rendering
  const renderTabContent = () => {
    switch(activeTab) {
      case 'book': return <BookDetails />;
      case 'blog': return <BlogDetails />;
      case 'course': return <CourseDetails />;
      default: return <p>Select a tab to view content (rendered via Switch)</p>;
    }
  }

  return (
    <div className="App" style={{ padding: '20px' }}>
      <h1>Blogger App - Conditional Rendering Ways</h1>

      {/* 1. If/Else Rendering section */}
      <div style={{ marginBottom: '20px', padding: '10px', background: '#f0f0f0' }}>
        <h2>1. If/Else Approach</h2>
        <button onClick={() => setShowBook(!showBook)}>Toggle Book</button>
        {bookContent}
      </div>

      {/* 2. Ternary Operator Rendering section */}
      <div style={{ marginBottom: '20px', padding: '10px', background: '#f9f9f9' }}>
        <h2>2. Ternary Operator Approach</h2>
        <button onClick={() => setShowBlog(!showBlog)}>Toggle Blog</button>
        {showBlog ? <BlogDetails /> : <p>Click to view Blog Details (rendered via Ternary)</p>}
      </div>

      {/* 3. Logical && Operator Rendering section */}
      <div style={{ marginBottom: '20px', padding: '10px', background: '#f0f0f0' }}>
        <h2>3. Logical && Operator Approach</h2>
        <button onClick={() => setShowCourse(!showCourse)}>Toggle Course</button>
        {showCourse && <CourseDetails />}
        {!showCourse && <p>Click to view Course Details (rendered via Logical &&)</p>}
      </div>

      {/* 4. Switch Statement Rendering section */}
      <div style={{ marginBottom: '20px', padding: '10px', background: '#f9f9f9' }}>
        <h2>4. Switch Statement Approach</h2>
        <button onClick={() => setActiveTab('book')}>Show Book Tab</button>
        <button onClick={() => setActiveTab('blog')} style={{ marginLeft: '10px' }}>Show Blog Tab</button>
        <button onClick={() => setActiveTab('course')} style={{ marginLeft: '10px' }}>Show Course Tab</button>
        <button onClick={() => setActiveTab('')} style={{ marginLeft: '10px' }}>Clear Tab</button>
        <div style={{ marginTop: '10px' }}>
          {renderTabContent()}
        </div>
      </div>
    </div>
  );
}

export default App;
