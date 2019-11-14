using FluentAssertions;
using NUnit.Framework;

namespace MarsRover.UnitTests
{
    internal class MoveEastCommandShould
    {
        [Test]
        public void IncrementXAxisOfPosition()
        {
            var testTrackingModule = new TrackingModule()
            {
                GridMaximumX = 2,
                GridMaximumY = 2,
                Position = new Position(1, 1, Orientation.E)
            };

            var testMoveEastCommand = new MoveEastCommand();

            testMoveEastCommand.Execute(testTrackingModule);

            var position = testTrackingModule.Position;

            position.Y.Should().Be(1);
            position.X.Should().Be(2);
            position.Orientation.Should().Be(Orientation.E);
        }

        [Test]
        public void NotIncrementXAxisPositionWhenAtMaximumXAxis()
        {
            var testTrackingModule = new TrackingModule()
            {
                GridMaximumX = 2,
                GridMaximumY = 2,
                Position = new Position(2, 1, Orientation.E)
            };

            var testMoveEastCommand = new MoveEastCommand();

            testMoveEastCommand.Execute(testTrackingModule);

            var position = testTrackingModule.Position;

            position.Y.Should().Be(1);
            position.X.Should().Be(2);
            position.Orientation.Should().Be(Orientation.E);
        }
    }
}