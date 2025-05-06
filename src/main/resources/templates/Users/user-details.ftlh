<!DOCTYPE html>
<html class="h-full" lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="h-full bg-gray-50">

<nav class="bg-blue-950 border-b-4 border-black fixed top-0 w-full z-50">
    <div class="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8">
        <div class="flex h-[7vw] items-center justify-between">
            <div class="flex items-center">
                <div>
                    <a href="/provider/dashboard">
                        <img class="h-32 w-32" src="/UniVents.png" alt="UniVents">
                    </a>
                </div>
                <div>
                    <div class="ml-10 flex items-baseline space-x-4 links">
                        <a href="/view-events" class="rounded-md px-3 py-2 text-sm font-medium text-white hover:bg-blue-900 hover:text-white">View Events</a>
                        <a href="/provider/manage-events" class="rounded-md px-3 py-2 text-sm font-medium text-white hover:bg-blue-900 hover:text-white">Manage Events</a>
                    </div>
                </div>
            </div>
            <div>
                <div class="ml-4 flex items-center space-x-4">
                    <a href="/userInfo">
                        <button type="button" class="relative rounded-md px-6 py-2 bg-gray-800 p-1 text-white hover:text-red">
                            Profile
                        </button>
                    </a>
                    <a href="/logout">
                        <button type="button" class="relative rounded-md px-6 py-2 bg-gray-800 p-1 text-white hover:text-red">
                            Log Out
                        </button>
                    </a>
                </div>
            </div>
        </div>
    </div>
</nav>

<script>
    function toggleUserMenu() {
        document.getElementById("user-menu").classList.toggle("hidden");
    }

    document.addEventListener("click", function(event) {
        const menu = document.getElementById("user-menu");
        const button = document.getElementById("user-menu-button");

        if (!menu.contains(event.target) && !button.contains(event.target)) {
            menu.classList.add("hidden");
        }
    });

</script>

<div class="ml-[20px] mt-[180px]">
    <div class="px-4 sm:px-0">
        <h3 class="text-base/7 font-semibold text-gray-900">Profile Information</h3>
        <p class="mt-1 max-w-2xl text-sm/6 text-gray-500">Personal details.</p>
    </div>
    <div class="mt-6 border-t border-gray-100">
        <dl class="divide-y divide-gray-100">
            <div class="px-4 py-6 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-0">
                <dt class="text-sm/6 font-medium text-gray-900">Username</dt>
                <dd class="mt-1 text-sm/6 text-gray-700 sm:col-span-2 sm:mt-0" id="profileFullName">${user.username}</dd>
            </div>
            <div class="px-4 py-6 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-0">
                <dt class="text-sm/6 font-medium text-gray-900">Email address</dt>
                <dd class="mt-1 text-sm/6 text-gray-700 sm:col-span-2 sm:mt-0" id="profileEmail">${user.email}</dd>
            </div>
            <div class="px-4 py-6 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-0">
                <dt class="text-sm/6 font-medium text-gray-900">Password</dt>
                <dd class="mt-1 text-sm/6 text-gray-700 sm:col-span-2 sm:mt-0" id="profilePassword">**********</dd>
            </div>
            <div class="px-4 py-6 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-0">
                <dt class="text-sm/6 font-medium text-gray-900">Role</dt>
                <dd class="mt-1 text-sm/6 text-gray-700 sm:col-span-2 sm:mt-0">${user.role}</dd>
            </div>
            <div class="px-4 py-6 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-0">
                <dt class="text-sm/6 font-medium text-gray-900">Account Status</dt>
                <dd class="mt-1 text-sm/6 text-gray-700 sm:col-span-2 sm:mt-0">${user.accountStatus}</dd>
            </div>
        </dl>
    </div>
</div>

<div class="ml-[20px] mt-4">
    <button onclick="openEditModal()" class="px-4 py-2 bg-blue-600 text-white rounded-md hover:bg-blue-700">
        Edit Profile
    </button>

    <form action="/users/delete/${userId}" method="get" class="inline-block mt-4">
        <input type="hidden" name="userId" value="${user.userId}" />
        <button type="submit" class="px-4 py-2 bg-red-600 text-white rounded-md hover:bg-red-700">
            Delete Profile
        </button>
    </form>
</div>

<!-- Profile Edit Modal -->
<div id="editProfileModal" class="fixed inset-0 hidden bg-black bg-opacity-50 flex items-center justify-center">
    <div class="bg-white p-6 rounded-lg shadow-lg max-w-md w-full">
        <h2 class="text-lg font-semibold text-gray-900 mb-4">Edit Profile</h2>

        <form id="editProfileForm" method="post" action="/users/update">
            <input type="hidden" name="userId" value="${user.userId}">

            <label class="block text-sm font-medium text-gray-900">Username</label>
            <input name="username" type="text" id="editFullName" class="w-full p-2 border rounded-md mb-2" value="${user.username}">

            <label class="block text-sm font-medium text-gray-900">Email Address</label>
            <input name="email" type="email" id="editEmail" class="w-full p-2 border rounded-md mb-2" value="${user.email}">

            <label class="block text-sm font-medium text-gray-900">Password</label>
            <input name="password" type="password" id="editPassword" class="w-full p-2 border rounded-md mb-2" value="${user.password}">

            <label class="block text-sm font-medium text-gray-900">Role</label>
            <input name="role" type="text" id="editRole" class="w-full p-2 border rounded-md mb-2" value="${user.role}">

            <label class="block text-sm font-medium text-gray-900">Account Status</label>
            <input name="accountStatus" type="text" id="editAccountStatus" class="w-full p-2 border rounded-md mb-4" value="${user.accountStatus}">

            <div class="flex justify-end space-x-2">
                <button type="button" onclick="closeEditModal()" class="px-4 py-2 bg-gray-500 text-white rounded-md hover:bg-gray-600">Cancel</button>
                <button type="submit" class="px-4 py-2 bg-blue-600 text-white rounded-md hover:bg-blue-700">Save Changes</button>
            </div>
        </form>

    </div>
</div>

<script>
    function openEditModal() {
        document.getElementById("editProfileModal").classList.remove("hidden");
    }

    function closeEditModal() {
        document.getElementById("editProfileModal").classList.add("hidden");
    }

    function saveProfileChanges() {
        document.getElementById("profileFullName").innerText = document.getElementById("editFullName").value;
        document.getElementById("profileEmail").innerText = document.getElementById("editEmail").value;
        document.getElementById("profilePassword").innerText = "**********";
        closeEditModal();
    }
</script>
</body>
</html>
