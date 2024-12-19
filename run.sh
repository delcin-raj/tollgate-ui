#!/bin/bash

# Define the daemon commands
COMMAND1="cargo tauri dev"
COMMAND2="npx tailwindcss -i src/style.css -o src/output.css --watch"

# Open GNOME Terminal with two tabs running the daemon commands
gnome-terminal \
  --tab --title="tauri dev" -- bash -c "$COMMAND1; exec bash" \
  --tab --title="tailwind watch" -- bash -c "$COMMAND2; exec bash"
