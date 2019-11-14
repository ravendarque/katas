namespace MarsRover {
    public class MoveNorthCommand : ICommand
    {
        public void Execute(TrackingModule trackingModule)
        {
            var newPositionY = trackingModule.Position.Y + 1;

            if (newPositionY <= trackingModule.GridMaximumY)
            {
                trackingModule.Position.Y = newPositionY;
            }
        }
    }
}