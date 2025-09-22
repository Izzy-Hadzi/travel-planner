import React, { useState, useEffect, useRef } from 'react';
//import { Link } from 'react-router-dom';
import '../styles/Navbar.css';

function Navbar() {
  const [isOpen, setIsOpen] = useState(false);
  const menuRef = useRef(null);
  const hamburgerRef = useRef(null);

  const toggleMenu = () => setIsOpen(prev => !prev);
  const closeMenu = () => setIsOpen(false);

  useEffect(() => {
    const handleClickOutside = (event) => {
      if (
        menuRef.current &&
        !menuRef.current.contains(event.target) &&
        hamburgerRef.current &&
        !hamburgerRef.current.contains(event.target)
      ) {
        closeMenu();
      }
    };

    document.addEventListener('mousedown', handleClickOutside);

    return () => {
      document.removeEventListener('mousedown', handleClickOutside);
    };
  }, []);

  return (
    <nav className="navbar">
      <div className="navbar-container">
        <ul className="navbar-menu">
          <li><a href="/">Page 1</a></li>
          <li><a href="/page2">Page 2</a></li>
          <li><a href="/page3">Page 3</a></li>
          <li><a href="/page4">Page 4</a></li>
          <li><a href="/page5">Page 5</a></li>
        </ul>

        <div className="navbar-action">
          <a
            href="https://jamesbuckhouse.substack.com/"
            className="navbar-newsletter"
            target="_blank"
            rel="noopener noreferrer"
          >
            Home
          </a>
        </div>

        <div className="navbar-hamburger" onClick={toggleMenu} ref={hamburgerRef}>
          <span></span>
          <span></span>
          <span></span>
        </div>

        <ul className={`navbar-mobile-menu ${isOpen ? 'active' : ''}`} ref={menuRef}>
            <li><a to="/" onClick={closeMenu}>Page 1</a></li>
            <li><a to="/account" onClick={closeMenu}>Page 2</a></li>
            <li><a to="/plannew" onClick={closeMenu}>Page 3</a></li>
            <li><a to="/mytrips" onClick={closeMenu}>Page 4</a></li>
            <li><a to="/aboutus" onClick={closeMenu}>Page 5</a></li>
        </ul>
      </div>
    </nav>
  );
}

export default Navbar;