using System;
using System.Collections.Generic;
using System.Linq;

namespace MarsRover
{
    public static class InputParser
    {
        private const char InputSeparator = '\n';

        public static MarsRoverInput Parse(string marsRoverInput)
        {
            var inputParts = marsRoverInput.Split(InputSeparator);
            var gridInput = inputParts[0].Split(' ');
            var positionInput = inputParts[1];
            var commandsInput = inputParts[2];

            var trackingModule = new TrackingModule
            {
                GridMaximumX = int.Parse(gridInput[0]),
                GridMaximumY = int.Parse(gridInput[1]),
                Position = ParsePosition(positionInput)
            };

            var commandModule = new CommandModule(ParseCommandChain(commandsInput));

            return new MarsRoverInput
            {
                TrackingModule = trackingModule,
                CommandModule = commandModule
            };
        }

        private static Position ParsePosition(string positionInput)
        {
            var position = positionInput.Split(' ');
            return new Position(
                int.Parse(position[0]),
                int.Parse(position[1]),
                (Orientation)Enum.Parse(typeof(Orientation), position[2])
            );
        }

        private static ICommand ParseCommandChain(string commandsInput)
        {
            ICommand previousCommand = null;
            ICommand currentCommand = null;

            foreach (var command in commandsInput.Reverse())
            {
                if (command == 'M')
                {
                    currentCommand = new MoveForwardCommand(previousCommand);
                }
                else if (command == 'L')
                {
                    currentCommand = new RotateLeftCommand(previousCommand);
                }
                else if (command == 'R')
                {
                    currentCommand = new RotateRightCommand(previousCommand);
                }

                previousCommand = currentCommand;
            }

            return currentCommand;
        }
    }
}