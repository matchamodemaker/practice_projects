# States
- move
- start -> playing -> over -> playing -> ...
- 

# Packages
## Controller
- UserInput
  - scan? buffer?
  - 출력까지 할거면 둘 다 buffer
  - read를 기다리고, 시간이 지나면 넘기기?
  - 그냥 쭉 받다가 frame 넘어가면 초기화?
  - ????
  - 

## Model
- GameObject
  - create
  - destroy
  - pixels
 
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