namespace MarsRover
{
    public class Position
    {
        public int X { get; set; }

        public int Y { get; set; }

        public Orientation Orientation { get; set; }

        public Position(int x, int y, Orientation orientation)
        {
            X = x;
            Y = y;
            Orientation = orientation;
        }

        public override string ToString()
        {
            return $"{X} {Y} {Orientation}";
        }
    }
}