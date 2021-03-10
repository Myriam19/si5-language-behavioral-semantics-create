# Syntaxe concrète textuelle

### Exemple d'utilisation

```java
CreateProgram prog1 {
	choreographies {
		FiniteChoreography moveObject {
			instructions {
				GrabInFront, Rotate 90 degrees, ReleaseInFront, Rotate 100 degrees 
			}
		},
		
		FiniteChoreography avoidRightObstacle{
			instructions {
				Rotate 1 degrees
			}
		},
		
		FiniteChoreography avoidLeftObstacle{
			instructions {
				Rotate -1 degrees
			}
		},
		
		FiniteChoreography turnBack{
			instructions {
				Rotate 180 degrees
			}
		},
		
		LoopChoreography clean {
			interruptions {
				Interruption (condition = ObjectFound at 5 cm, choreography = moveObject),
				Interruption (condition = (ObstacleFoundLeft && ObstacleFoundRight), choreography = turnBack),
				Interruption (condition = ObstacleFoundLeft, choreography = avoidLeftObstacle),
				Interruption (condition = ObstacleFoundRight, choreography = avoidRightObstacle)
			}
			instructions {
				GoForward  100 cm
			}
			outCondition : VirtualWallFound
		}
	}
	starting_choreo : clean
}
```
