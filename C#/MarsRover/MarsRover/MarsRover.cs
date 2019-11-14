namespace MarsRover
{
    public class MarsRover
    {
        public static string Move(string marsRoverInput)
        {
            var parsedMarsRoverInput = InputParser.Parse(marsRoverInput);
            var trackingModule = parsedMarsRoverInput.TrackingModule;
            
            var commandModule = parsedMarsRoverInput.CommandModule;
            commandModule.Execute(trackingModule);

            var position = trackingModule.Position;
            return position.ToString();
        }
    }
}