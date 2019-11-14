using System;

namespace MarsRover
{
    public static class MoveForwardCommandFactory
    {
        public static ICommand Create(Orientation orientation)
        {
            switch (orientation)
            {
                case Orientation.N:
                    return new MoveNorthCommand();
                case Orientation.E:
                    return new MoveEastCommand();
                case Orientation.S:
                    return new MoveSouthCommand();
                case Orientation.W:
                    return new MoveWestCommand();
                default:
                    throw new ArgumentException($"{nameof(orientation)} must be N/E/S/W");
            }
        }
    }
}