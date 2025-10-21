# States
- move
- start -> playing -> over -> playing -> ...
- 

# Packages
## Controller
- UserInput
  - BufferReader에서 ready() 사용해서 넘기거나 입력 업데이트

## Model
- GameObject
  - create
  - destroy
  - poses
  - pixel
 
- Snake -> GameObject
  - eat
  - grow
  - move
  - speed
 
- Apple -> GameObject
  - delay

## View
- Draw
- Board
  - pixel info

## Game
- Loop
  - run
- Collision

# Structure
Loop -> UserInput -> GameObject, Collision
Loop -> Draw -> GameObject

interface?

control
model(game object)
view
internal?

### TODO
- save
  - as a file
  - numbers to save???
    - best score, game state
    - snake, apple
      - position, direction, speed?
      - 