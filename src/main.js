const { invoke } = window.__TAURI__.core;

let greetInputEl;
let greetMsgEl;

async function ping() {
  let response = await invoke("plugin:androidwifi|ping", { payload: { value: greetInputEl.value } });
  greetMsgEl.textContent = response.value;
}

window.addEventListener("DOMContentLoaded", () => {
  greetInputEl = document.querySelector("#greet-input");
  greetMsgEl = document.querySelector("#greet-msg");
  document.querySelector("#greet-form").addEventListener("submit", (e) => {
    e.preventDefault();
    ping();
  });
});
