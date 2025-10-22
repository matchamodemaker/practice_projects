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
  - 객체 하나 만들고 좌표만 바꾸기 vs 새로 계속 만들기
  - 만드는게 더 논리적이다?
    - random으로 snake랑 겹치치 않게, board 안에 생성되도록
    - board 사이즈를 어떻게 넘기지?
    - Main에서 readConfig
      - Loop.run() -> Board.draw() ?
    - 아니면 configClass 만들고 singleton으로 여기저기서 찾아보기
      - 하나의 큰 configClass?
      - 

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