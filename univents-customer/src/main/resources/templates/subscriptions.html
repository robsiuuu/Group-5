<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Subscriptions</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100">

<!-- Navbar -->
<nav class="bg-blue-950 border-b-4 border-black fixed top-0 w-full z-50">
    <div class="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8">
        <div class="flex h-[7vw] items-center justify-between">
            <div class="flex items-center">
                <img class="h-32 w-32" src="/UniVents.png" alt="UniVents">
                <div class="ml-10 flex items-baseline space-x-4 links">
                    <a href="home" class="text-white px-3 py-2 text-sm font-medium hover:bg-blue-900 rounded-md">Dashboard</a>
                    <a href="profile" class="text-white px-3 py-2 text-sm font-medium hover:bg-blue-900 rounded-md">Profile</a>
                </div>
            </div>
            <button onclick="logout()" class="bg-gray-800 text-white px-4 py-2 rounded hover:bg-red-700">Log Out</button>
        </div>
    </div>
</nav>

<!-- Subscriptions Section -->
<div class="pt-[10vw] px-4">
    <div class="bg-white p-6 rounded-lg shadow-lg max-w-4xl mx-auto">
        <h2 class="text-2xl font-bold text-center text-gray-900 mb-6">My Subscribed Events</h2>
        <div id="subscriptionsList" class="space-y-4"></div>
    </div>
</div>

<script>
    const userId = localStorage.getItem("loggedInUserId");

    function logout() {
      localStorage.removeItem("loggedInUserId");
      localStorage.removeItem("loggedInUsername");
      window.location.href = "/login";
    }

    // Load user's subscriptions
    function loadSubscriptions() {
      fetch(`/api/subscriptions/user/${userId}`)
        .then(res => res.json())
        .then(events => {
          const container = document.getElementById("subscriptionsList");
          container.innerHTML = "";

          if (!events || events.length === 0) {
            container.innerHTML = '<p class="text-center text-gray-600">You have not subscribed to any events yet.</p>';
            return;
          }

          events.forEach(event => {
            const eventDiv = document.createElement("div");
            eventDiv.className = "flex justify-between items-center bg-gray-100 p-4 rounded-lg border border-gray-300";

            eventDiv.innerHTML = `
              <div>
                <h3 class="text-lg font-semibold text-gray-900">${event.title}</h3>
                <p class="text-gray-600 text-sm">${event.description || 'No description available.'}</p>
              </div>
              <button onclick="unsubscribe(${event.id})" class="bg-red-600 text-white px-4 py-2 rounded hover:bg-red-700">Unsubscribe</button>
            `;

            container.appendChild(eventDiv);
          });
        })
        .catch(err => console.error("Error loading subscriptions:", err));
    }

    // Unsubscribe from an event
    function unsubscribe(eventId) {
      fetch("/api/subscriptions", {
        method: "DELETE",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
          userId: parseInt(userId),
          eventId: eventId
        })
      })
      .then(res => {
        if (res.ok) {
          loadSubscriptions(); // Reload after unsubscribing
        } else {
          alert("Failed to unsubscribe.");
        }
      })
      .catch(err => console.error("Error unsubscribing:", err));
    }

    // Load subscriptions on page load
    window.onload = loadSubscriptions;
</script>

</body>
</html>
