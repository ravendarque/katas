namespace MarsRover
{
    public class TrackingModule
    {
        public Position Position { get; set; }

        public int GridMaximumX { get; set; }

        public int GridMaximumY { get; set; }

        public int GridMinimumY => 1;

        public int GridMinimumX => 1;
    }
}