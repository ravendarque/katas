namespace MarsRover
{
    public class MoveSouthCommand : ICommand
    {
        public void Execute(TrackingModule trackingModule)
        {
            var newPositionY = trackingModule.Position.Y - 1;

            if (newPositionY >= trackingModule.GridMinimumY)
            {
                trackingModule.Position.Y = newPositionY;
            }
        }
    }
}