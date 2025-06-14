#!/bin/bash

# Ustawienia katalogów
SRC_DIR="src/main/java"
OUT_DIR="out"
MAIN_CLASS="pl.unittest.fourteenth_lab.MaterialPointMain"

# Domyślny numer testu = 1, jeśli nie podano
TEST_NUM=${1:-1}
DATA_FILE="$SRC_DIR/pl/unittest/fourteenth_lab/data/data${TEST_NUM}.txt"

# Tworzenie katalogu wyjściowego
mkdir -p "$OUT_DIR"

# Kompilacja wszystkich plików Java
find "$SRC_DIR" -name "*.java" > sources.txt
javac -d "$OUT_DIR" @sources.txt

if [ $? -ne 0 ]; then
    echo "Kompilacja nie powiodła się."
    exit 1
fi

# Sprawdzenie czy plik wejściowy istnieje
if [ ! -f "$DATA_FILE" ]; then
    echo "Nie znaleziono pliku: $DATA_FILE"
    exit 2
fi

echo "Uruchamianie testu #$TEST_NUM (plik: data${TEST_NUM}.txt)"
java -cp "$OUT_DIR" "$MAIN_CLASS" < "$DATA_FILE"
rm sources.txt
