<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Events</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<div class="isolate bg-white px-6 py-24 sm:py-32 lg:px-8">
    <div class="absolute inset-x-0 top-[-10rem] -z-10 transform-gpu overflow-hidden blur-3xl sm:top-[-20rem]" aria-hidden="true">
        <div class="relative left-1/2 -z-10 aspect-1155/678 w-[36.125rem] max-w-none -translate-x-1/2 rotate-[30deg] bg-gradient-to-tr from-[#ff80b5] to-[#9089fc] opacity-30 sm:left-[calc(50%-40rem)] sm:w-[72.1875rem]" style="clip-path: polygon(74.1% 44.1%, 100% 61.6%, 97.5% 26.9%, 85.5% 0.1%, 80.7% 2%, 72.5% 32.5%, 60.2% 62.4%, 52.4% 68.1%, 47.5% 58.3%, 45.2% 34.5%, 27.5% 76.7%, 0.1% 64.9%, 17.9% 100%, 27.6% 76.8%, 76.1% 97.7%, 74.1% 44.1%)"></div>
    </div>
    <div class="mx-auto max-w-2xl text-center">
        <h2 class="text-4xl font-semibold tracking-tight text-balance text-gray-900 sm:text-5xl">${title}</h2>
        <p class="mt-2 text-lg/8 text-gray-600">Be sure to input all fields.</p>
    </div>
    <#if error??>
        <div class="mb-4 text-sm text-red-600 font-medium bg-red-100 p-2 rounded">
            ${error}
        </div>
    </#if>

    <form action="/events/update" method="post" class="mx-auto mt-16 max-w-xl sm:mt-20">
        <input type="hidden" name="eventId" value="${event.eventId}"/>

        <div class="grid grid-cols-1 gap-x-8 gap-y-6 sm:grid-cols-2">
            <div>
                <label for="eventName" class="block text-sm/6 font-semibold text-gray-900">Title</label>
                <div class="mt-2.5">
                    <input type="text" name="eventName" id="eventName" value="${event.eventName!}" class="block w-full rounded-md border border-gray-300 bg-white px-3.5 py-2 text-base text-gray-900">
                </div>
            </div>

            <div>
                <label for="eventDate" class="block text-sm/6 font-semibold text-gray-900">Date</label>
                <div class="mt-2.5">
                    <input type="date"
                           name="eventDate"
                           id="eventDate"
                           value="${event.eventDate?string('yyyy-MM-dd')}"
                           class="block w-full rounded-md border border-gray-300 bg-white px-3.5 py-2 text-base text-gray-900">
                </div>
            </div>

            <div>
                <label for="eventTime" class="block text-sm/6 font-semibold text-gray-900">Time</label>
                <div class="mt-2.5">
                    <input type="time"
                           name="eventTime"
                           id="eventTime"
                           value="${event.eventTime?string('yyyy-MM-dd\'T\'HH:mm')}"
                           class="block w-full rounded-md border border-gray-300 bg-white px-3.5 py-2 text-base text-gray-900">
                </div>
            </div>

            <div class="sm:col-span-2">
                <label for="eventLocation" class="block text-sm/6 font-semibold text-gray-900">Location</label>
                <div class="mt-2.5">
                    <input type="text" name="eventLocation" id="eventLocation" value="${event.eventLocation!}"
                           class="block w-full rounded-md border border-gray-300 bg-white px-3.5 py-2 text-base text-gray-900 outline-none placeholder:text-gray-400 focus:ring-2 focus:ring-indigo-600"
                           placeholder="Enter event location">
                </div>
            </div>

            <input type="hidden" name="latitude" id="latitude" value="${event.latitude!}">
            <input type="hidden" name="longitude" id="longitude" value="${event.longitude!}">


            <div class="sm:col-span-2">
                <label for="eventDescription" class="block text-sm/6 font-semibold text-gray-900">Description</label>
                <div class="mt-2.5">
                    <textarea name="eventDescription" id="eventDescription" rows="4" class="block w-full rounded-md border border-gray-300 bg-white px-3.5 py-2 text-base text-gray-900">${event.eventDescription!}</textarea>
                </div>
            </div>
        </div>

        <div class="mt-10 flex gap-4">
            <button type="submit" class="w-full rounded-md bg-blue-900 px-3.5 py-2.5 text-sm font-semibold text-white hover:bg-indigo-500">Update Event</button>
            <a href="/events/myEvents" class="w-full text-center rounded-md bg-gray-200 px-3.5 py-2.5 text-sm font-semibold text-gray-700 hover:bg-gray-300">Cancel</a>
        </div>
    </form>

</div>

<script src="https://maps.googleapis.com/maps/api/js?key=KEYHERE&libraries=places"></script>
<script>
    function initAutocomplete() {
        const input = document.getElementById('eventLocation');
        const autocomplete = new google.maps.places.Autocomplete(input);
        autocomplete.setFields(['geometry', 'formatted_address']);

        autocomplete.addListener('place_changed', function () {
            const place = autocomplete.getPlace();
            if (place.geometry) {
                document.getElementById('latitude').value = place.geometry.location.lat();
                document.getElementById('longitude').value = place.geometry.location.lng();
            }
        });
    }

    window.addEventListener('load', initAutocomplete);
</script>



</body>
</html>
