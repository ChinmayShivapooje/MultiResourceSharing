// Signup logic
document.getElementById('signupForm')?.addEventListener('submit', async function(e) {
    e.preventDefault();
    const form = new FormData(this);
    const data = Object.fromEntries(form.entries());

    const res = await fetch('http://localhost:8080/api/main/send', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(data)
    });

    if (res.ok) {
        alert('Signup successful!');
        window.location.href = 'login.html';
    } else {
        alert('Signup failed.');
    }
});

// Login logic
document.getElementById('loginForm')?.addEventListener('submit', async function(e) {
    e.preventDefault();
    const form = new FormData(this);
    const data = Object.fromEntries(form.entries());

    const res = await fetch('http://localhost:8080/api/main/login', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(data)
    });

    if (res.ok) {
        alert('Login successful!');
        window.location.href = 'dashboard.html';
    } else {
        alert('Invalid credentials.');
    }
});
