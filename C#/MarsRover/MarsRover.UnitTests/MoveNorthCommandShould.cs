using FluentAssertions;
using NUnit.Framework;

namespace MarsRover.UnitTests
{
    internal class MoveNorthCommandShould
    {
        [Test]
        public void IncrementYAxisOfPosition()
        {
            var testTrackingModule = new TrackingModule()
            {
                GridMaximumX = 2,
                GridMaximumY = 2,
                Position = new Position(1, 1, Orientation.N)
            };

            var testMoveNorthCommand = new MoveNorthCommand();
            
            testMoveNorthCommand.Execute(testTrackingModule);

            var position = testTrackingModule.Position;
            
            position.Y.Should().Be(2);
            position.X.Should().Be(1);
            position.Orientation.Should().Be(Orientation.N);
        }

        [Test]
        public void NotIncrementYAxisPositionWhenAtMaximumYAxis()
        {
            var testTrackingModule = new TrackingModule()
            {
                GridMaximumX = 2,
                GridMaximumY = 2,
                Position = new Position(1, 2, Orientation.N)
            };

            var testMoveNorthCommand = new MoveNorthCommand();

            testMoveNorthCommand.Execute(testTrackingModule);

            var position = testTrackingModule.Position;

            position.Y.Should().Be(2);
            position.X.Should().Be(1);
            position.Orientation.Should().Be(Orientation.N);
        }
    }
}
