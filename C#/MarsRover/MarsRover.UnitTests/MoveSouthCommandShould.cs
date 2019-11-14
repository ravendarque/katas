using FluentAssertions;
using NUnit.Framework;

namespace MarsRover.UnitTests
{
    internal class MoveSouthCommandShould
    {
        [Test]
        public void DecrementYAxisOfPosition()
        {
            var testTrackingModule = new TrackingModule()
            {
                GridMaximumX = 2,
                GridMaximumY = 2,
                Position = new Position(2, 2, Orientation.S)
            };

            var testMoveSouthCommand = new MoveSouthCommand();

            testMoveSouthCommand.Execute(testTrackingModule);

            var position = testTrackingModule.Position;

            position.Y.Should().Be(1);
            position.X.Should().Be(2);
            position.Orientation.Should().Be(Orientation.S);
        }

        [Test]
        public void NotDecrementYAxisOfPositionWhenAtMinimumYAxis()
        {
            var testTrackingModule = new TrackingModule()
            {
                GridMaximumX = 2,
                GridMaximumY = 2,
                Position = new Position(2, 1, Orientation.S)
            };

            var testMoveSouthCommand = new MoveSouthCommand();

            testMoveSouthCommand.Execute(testTrackingModule);

            var position = testTrackingModule.Position;

            position.Y.Should().Be(1);
            position.X.Should().Be(2);
            position.Orientation.Should().Be(Orientation.S);
        }
    }
}