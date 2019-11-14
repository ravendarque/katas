namespace MarsRover.UnitTests
{
    internal class SpyCommand : ICommand
    {
        public TrackingModule TrackingModule;

        public void Execute(TrackingModule trackingModule)
        {
            TrackingModule = trackingModule;
        }
    }
}