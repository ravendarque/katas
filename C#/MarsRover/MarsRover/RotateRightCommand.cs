using System.Collections.Generic;

namespace MarsRover
{
    public class RotateRightCommand : ICommand
    {
        private static readonly Dictionary<Orientation, Orientation> RotationMappings = new Dictionary<Orientation, Orientation>
        {
            {Orientation.N, Orientation.E},
            {Orientation.E, Orientation.S},
            {Orientation.S, Orientation.W},
            {Orientation.W, Orientation.N}
        };

        private readonly ICommand _nextCommandInChain;

        public void Execute(TrackingModule trackingModule)
        {
            trackingModule.Position.Orientation = RotationMappings[trackingModule.Position.Orientation];

            _nextCommandInChain?.Execute(trackingModule);
        }

        public RotateRightCommand(ICommand nextCommandInChain)
        {
            _nextCommandInChain = nextCommandInChain;
        }
    }
}