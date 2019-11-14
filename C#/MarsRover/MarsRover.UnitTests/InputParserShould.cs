using FluentAssertions;
using NUnit.Framework;

namespace MarsRover.UnitTests
{
    [TestFixture]
    public class InputParserShould
    {
        [Test]
        public void ParseTrackingInput()
        {
            const string testMarsRoverInput = "1 1\n1 1 N\nM";

            var result = InputParser.Parse(testMarsRoverInput);

            result.TrackingModule
                  .Should()
                  .Match<TrackingModule>(
                      tm => tm.GridMaximumX == 1 &&
                            tm.GridMaximumY == 1 &&
                            tm.Position.Orientation == Orientation.N &&
                            tm.Position.X == 1 &&
                            tm.Position.Y == 1
                  );
        }
    }
}