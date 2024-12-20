#!/bin/bash

# Start the tailwind watch server
npx tailwindcss -i src/input.css -o src/output.css --watch

# For some reason by default target x86_64 is not built
# In my machine android studio virtual machines with armeabiv7 images crashed
# It is also optimal to emulate in x86_64 arch
# The following resolved

cargo tauri build -t x86_64

# Assuming you have android vm running
cargo tauri android open

