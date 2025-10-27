# Packages
## Controller
- UserInput

## Model
- GameObject
- Snake -> GameObject
- Apple -> GameObject
- Board

## Game
- Loop
  - run
- Collision

# Structure
Loop -> UserInput -> GameObject, Collision
Loop -> Draw -> GameObject


### TODO
- save
  - as a file
  - numbers to save???
    - best score, game state
    - snake, apple
      - position, direction, speed?
- separate input-draw threads
  - how?
- add more states
  - initial, playing, pause