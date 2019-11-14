namespace MarsRover
{
    public class MoveForwardCommand : ICommand
    {
        private readonly ICommand _nextCommandInChain;

        public void Execute(TrackingModule trackingModule)
        {
            MoveForward(trackingModule);

            _nextCommandInChain?.Execute(trackingModule);
        }

        public MoveForwardCommand(ICommand nextCommandInChain)
        {
            _nextCommandInChain = nextCommandInChain;
        }

        private static void MoveForward(TrackingModule trackingModule)
        {
            var command = MoveForwardCommandFactory.Create(trackingModule.Position.Orientation);

            command.Execute(trackingModule);
        }
    }
}