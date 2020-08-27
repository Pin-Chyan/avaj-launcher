SRC_1 = ./flyables/Aircraft.java \
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

SRC_2 = ./flyables/Aircraft.class \
	./flyables/AircraftFactory.class \
	./flyables/Baloon.class \
	./flyables/Coords.class \
	./flyables/Flyable.class \
	./flyables/Helicopter.class \
	./flyables/Jetplane.class \
	./Avaj.class \
	./simulator/Tower.class \
	./simulator/Validator.class \
	./simulator/WriteFile.class \
	./weather/WeatherProvider.class \
	./weather/WeatherTower.class \

RED = "\u001B[0;31m"
GREEN = "\u001B[0;32m"
NOCOLOR = "\u001B[0m"

.PHONY: clean all

all: build run

build:
	@echo -e $(GREEN)"Making A Class Session For You"$(NOCOLOR)
	@javac -sourcepath -h $(SRC_1)

clean:
	@echo -e $(RED)"Cleaning Your Class"$(NOCOLOR)
	@rm -rf $(SRC_2)

run:
	@java Avaj.java scenario.txt