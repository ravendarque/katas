namespace MarsRover {
    public class MoveEastCommand : ICommand
    {
        public void Execute(TrackingModule trackingModule)
        {
            var newPositionX = trackingModule.Position.X + 1;

            if (newPositionX <= trackingModule.GridMaximumX)
            {
                trackingModule.Position.X = newPositionX;
            }
        }
    }
}