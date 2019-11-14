namespace MarsRover
{
    public interface ICommand
    {
        void Execute(TrackingModule trackingModule);
    }
}