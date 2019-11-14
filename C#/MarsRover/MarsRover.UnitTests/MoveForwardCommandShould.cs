using FluentAssertions;
using NUnit.Framework;

namespace MarsRover.UnitTests
{
    internal class MoveForwardCommandShould
    {
        [TestCase(Orientation.N, 2, 3)]
        [TestCase(Orientation.E, 3, 2)]
        [TestCase(Orientation.S, 2, 1)]
        [TestCase(Orientation.W, 1, 2)]
        public void Move(Orientation testOrientation, int expectedXPosition, int expectedYPosition)
        {
            const int testX = 2;
            const int testY = 2;
            var testPosition = new Position(testX, testY, testOrientation);

            const int testGridSizeX = 3;
            const int testGridSizeY = 3;
            var testTrackingModule = new TrackingModule
            {
                GridMaximumX = testGridSizeX,
                GridMaximumY = testGridSizeY,
                Position = testPosition
            };

            var spyCommand = new SpyCommand();
            var moveCommand = new MoveForwardCommand(spyCommand);
            moveCommand.Execute(testTrackingModule);

            var actualTrackingModule = spyCommand.TrackingModule;
            actualTrackingModule.Position.Y.Should().Be(expectedYPosition);
            actualTrackingModule.Position.X.Should().Be(expectedXPosition);
        }
    }
}