#!/bin/sh

cp -r cli/lyntax ./lyntax-cli
zip -r "lyntax-cli.zip" "lyntax-cli"
rm -rf lyntax-cli

cp -r gui/lyntax/Release/Lyntax ./lyntax-gui
cd lyntax-gui && chmod +x Lyntax.jar && cd ..
zip -r "lyntax-gui.zip" "lyntax-gui"
rm -rf lyntax-gui
