import React from 'react';
import './Navigation.scss';
import Link from '../Link';

function Navigation() {
  return (
    <ul className="Navigation" role="menu">
      <li className="Navigation-item">
        <a className="Navigation-link" href="/" onClick={Link.onCl}>Home</a>
      </li>
      <li className="Navigation-item">
        <a className="Navigation-link" href="/about" onClick={Link.handleClick}>About</a>
      </li>
    </ul>
  );
}

export default Navigation;
