using System.Collections.Generic;

namespace MarsRover
{
    public class RotateLeftCommand : ICommand
    {
        private static readonly Dictionary<Orientation, Orientation> RotationMappings = new Dictionary<Orientation, Orientation>
        {
            {Orientation.N, Orientation.W},
            {Orientation.E, Orientation.N},
            {Orientation.S, Orientation.E},
            {Orientation.W, Orientation.S}
        };

        private readonly ICommand _nextCommandInChain;

        public void Execute(TrackingModule trackingModule)
        {
            trackingModule.Position.Orientation = RotationMappings[trackingModule.Position.Orientation];

            _nextCommandInChain?.Execute(trackingModule);
        }

        public RotateLeftCommand(ICommand nextCommandInChain)
        {
            _nextCommandInChain = nextCommandInChain;
        }
    }
}