##
## Makefile for  in /home/java
## 
## Made by VY Terence
## Login   <vy_t@etna-alternance.net>
## 
## Started on  Sat Sep 30 10:49:32 2017 VY Terence
## Last update Tue Oct  3 11:36:02 2017 VY Terence
##

JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
			$(JC) $(JFLAGS) $*.java

CLASSES = 	\
		Main.java \
		Character/Character.java \
		Character/ICharacter.java \
		Character/IWeapon.java \
		Character/Weapon.java \
		Character/Player.java \
		Character/IPlayer.java \
		Ennemy/Ennemy.java \
		Ennemy/IEnnemy.java \
		Room/Room.java \
		Room/IRoom.java \
		Game/Game.java


default:	classes

classes: 	$(CLASSES:.java=.class)

clean:
			$(RM) *.class
			$(RM) Character/*.class
			$(RM) Ennemy/*.class
			$(RM) Room/*.class
			$(RM) Game/*.class