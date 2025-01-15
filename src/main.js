const { invoke } = window.__TAURI__.core;

let greetInputEl;
let greetMsgEl;

async function getWifiDetails() {
  let response = await invoke("plugin:androidwifi|getWifiDetails", { payload: { value: "" } });
  const wifiNetworks = JSON.parse(response.wifis);
  const container = document.getElementById('wifi-list');
  container.innerHTML = ''; // clear out anything existing

  wifiNetworks.forEach(network => {
    // Build a small "card" with Tailwind utility classes
    const itemHTML = `
      <div class="bg-white shadow-md rounded-lg p-4">
        <h2 class="text-lg font-semibold mb-2">SSID: ${network.ssid}</h2>
        <p class="text-gray-700"><strong>BSSID:</strong> ${network.bssid}</p>
        <p class="text-gray-700"><strong>Signal (RSSI):</strong> ${network.rssi} dBm</p>
        <p class="text-gray-700"><strong>Capabilities:</strong> ${network.capabilities}</p>
        <p class="text-gray-700"><strong>Frequency:</strong> ${network.frequency} MHz</p>
      </div>
    `;
    // Insert the card into the container
    container.insertAdjacentHTML('beforeend', itemHTML);
  });
}

window.addEventListener("DOMContentLoaded", () => {
  greetInputEl = document.querySelector("#greet-input");
  greetMsgEl = document.querySelector("#greet-msg");
  document.querySelector("#greet-form").addEventListener("submit", (e) => {
    e.preventDefault();
    getWifiDetails();
  });
});
