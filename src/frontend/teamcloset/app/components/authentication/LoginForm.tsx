// import { setCookie } from 'cookies-next';
// import { parseCookie } from 'next/dist/compiled/@edge-runtime/cookies';
// import { getCookies } from 'cookies-next';
//import { cookies } from 'next/headers';
import React, { useState } from 'react';
import { useRouter } from 'next/navigation';


const LoginForm = (props) => {
  // manage input values
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  // manage error message
  const [errorMessage, setErrorMessage] = useState('');

  const webUrl = "http://localhost:8080/api/v1/auth/signin"; 

  const router = useRouter();

  const handleSubmit = async (event) => {
    event.preventDefault();

    const data = {
      username: event.target.username.value,
      password: event.target.password.value,
    };

    try {
      const response = await fetch(webUrl, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          // 'Access-Control-Allow-Origin': webUrl,
          // 'Vary': 'Origin'
        },
        body: JSON.stringify(data),
      });

      if (!response.ok) {
        // checking if response status is not OK (as in a 4-- or 5-- response status code)
        throw new Error(`You're flagged! Have a glass of water and try again with valid credentials.`);
      }

      if (response.ok) {
       
        console.log(data);
        console.log(data.username);
        console.log(response.headers.get('User-ID'));
        
        router.push('/closet');
        
        
    }

      console.log("request data:", data);
    

      // reset input values and error message upon successful submission
      setUsername('');
      setPassword('');
      setErrorMessage('');

      //handle error
    } catch (error) {
      setErrorMessage(error.message);
      console.error('Login Error:', error);
    }
  };

  return (
    <div className="flex justify-center, border-2 p-2 m-2">
      <form onSubmit={handleSubmit}>
        {/* <h1>Login</h1> */}
        {/* error message only displayes if present */}
        {errorMessage && <div style={{ color: 'red' }}>{errorMessage}</div>}
        <div className="container">
          <div className="row">
            <div className="form-item col-4, border-2 p-2 m-2">
              <label>Username</label>
              {/* value and onChange make inputs controlled components */}
              <input
                type="text"
                autoComplete="off"
                id="username"
                value={username}
                onChange={(event) => setUsername(event.target.value)}
              />
            </div>
          </div>
        </div>
        <div className="container">
          <div className="row">
            <div className="form-item col-4, border-2 p-2 m-2">
              <label>Password</label>
              <input
                type="password"
                autoComplete="off"
                id="password"
                value={password}
                onChange={(event) => setPassword(event.target.value)}
              />
            </div>
          </div>
        </div>
        <button className="bg-rose-50 p-2 hover:bg-rose-100" type="submit">Login!</button>
      </form>
    </div>
  );
};

export default LoginForm;