namespace MarsRover
{
    public class MoveWestCommand : ICommand
    {
        public void Execute(TrackingModule trackingModule)
        {
            var newPositionX = trackingModule.Position.X - 1;

            if (newPositionX >= trackingModule.GridMinimumX)
            {
                trackingModule.Position.X = newPositionX;
            }
        }
    }
}