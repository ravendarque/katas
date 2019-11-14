namespace MarsRover
{
    public class CommandModule
    {
        private readonly ICommand _command;

        public CommandModule(ICommand command)
        {
            _command = command;
        }

        public void Execute(TrackingModule trackingModule)
        {
            _command?.Execute(trackingModule);
        }
    }
}