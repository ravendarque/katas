using FluentAssertions;
using NUnit.Framework;

namespace MarsRover.UnitTests {
    internal class MoveWestCommandShould
    {
        [Test]
        public void DecrementXAxisOfPosition()
        {
            var testTrackingModule = new TrackingModule()
            {
                GridMaximumX = 2,
                GridMaximumY = 2,
                Position = new Position(2, 2, Orientation.W)
            };

            var testMoveWestCommand = new MoveWestCommand();

            testMoveWestCommand.Execute(testTrackingModule);

            var position = testTrackingModule.Position;

            position.Y.Should().Be(2);
            position.X.Should().Be(1);
            position.Orientation.Should().Be(Orientation.W);
        }

        [Test]
        public void NotDecrementXAxisOfPositionWhenAtMinimumXAxis()
        {
            var testTrackingModule = new TrackingModule()
            {
                GridMaximumX = 2,
                GridMaximumY = 2,
                Position = new Position(1, 2, Orientation.W)
            };

            var testMoveWestCommand = new MoveWestCommand();

            testMoveWestCommand.Execute(testTrackingModule);

            var position = testTrackingModule.Position;

            position.Y.Should().Be(2);
            position.X.Should().Be(1);
            position.Orientation.Should().Be(Orientation.W);
        }
    }
}