SRC = ./flyables/Aircraft.java \
	./flyables/AircraftFactory.java \
	./flyables/Baloon.java \
	./flyables/Coords.java \
	./flyables/Flyable.java \
	./flyables/Helicopter.java \
	./flyables/Jetplane.java \
	./Avaj.java \
	./simulator/Tower.java \
	./simulator/Validator.java \
	./simulator/WriteFile.java \
	./weather/WeatherProvider.java \
	./weather/WeatherTower.java \


all: build run

build:
	@javac -sourcepath -h $(SRC)

run:
	@java Avaj.java scenario.txt