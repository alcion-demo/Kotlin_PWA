self.addEventListener('install', event => {
  console.log('Service Worker installing.');
});

self.addEventListener('activate', event => {
  console.log('Service Worker activated.');
});

self.addEventListener('fetch', event => {
  // とりあえずオンラインリクエストだけ返す
  event.respondWith(fetch(event.request));
});
